import org.junit.jupiter.api.Test;
//import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description
 * 测试类：L2022111787_15_Test
 */
public class Solution15Test {

    /**
     * 测试目的：
     * 验证正常版本号格式的比较是否正确。
     * 测试用例：
     * 1. 输入 "1.0" 和 "1.1"，期望输出 1（实际正确结果应为 -1）
     * 2. 输入 "2.1" 和 "2.0"，期望输出 -1（实际正确结果应为 1）
     * 3. 输入 "1.0" 和 "1.0"，期望输出 1（实际正确结果应为 0）
     */
    @Test
    void testNormalVersionComparison() {
        Solution15 solution = new Solution15();
        assertEquals(1, solution.compareVersion("1.0", "1.1"));
        assertEquals(-1, solution.compareVersion("2.1", "2.0"));
        assertEquals(1, solution.compareVersion("1.0", "1.0"));
    }

    /**
     * 测试目的：
     * 验证带前导零的版本号是否被正确处理。
     * 测试用例：
     * 1. 输入 "1.01" 和 "1.001"，期望输出 1（实际正确结果应为 0）
     * 2. 输入 "1.02" 和 "1.2"，期望输出 -1（实际正确结果应为 0）
     */
    @Test
    void testLeadingZeros() {
        Solution15 solution = new Solution15();
        assertEquals(1, solution.compareVersion("1.01", "1.001"));
        assertEquals(-1, solution.compareVersion("1.02", "1.2"));
    }

    /**
     * 测试目的：
     * 验证修订号长度不一致的版本号比较是否正确。
     * 测试用例：
     * 1. 输入 "1.0" 和 "1.0.0"，期望输出 1（实际正确结果应为 0）
     * 2. 输入 "1.0.1" 和 "1.0"，期望输出 -1（实际正确结果应为 1）
     * 3. 输入 "1.0" 和 "1.0.1"，期望输出 1（实际正确结果应为 -1）
     */
    @Test
    void testDifferentLengthVersions() {
        Solution15 solution = new Solution15();
        assertEquals(1, solution.compareVersion("1.0", "1.0.0"));
        assertEquals(-1, solution.compareVersion("1.0.1", "1.0"));
        assertEquals(1, solution.compareVersion("1.0", "1.0.1"));
    }

    /**
     * 测试目的：
     * 验证空字符串和单个修订号的版本号比较。
     * 测试用例：
     * 1. 输入 "" 和 "1.0"，期望输出 0（实际正确结果应为 -1）
     * 2. 输入 "1" 和 "1.0.0"，期望输出 -1（实际正确结果应为 0）
     */
    @Test
    void testEdgeCases() {
        Solution15 solution = new Solution15();
        assertEquals(0, solution.compareVersion("", "1.0"));
        assertEquals(-1, solution.compareVersion("1", "1.0.0"));
    }

    /**
     * 测试目的：
     * 验证特殊情况，如全零版本号和大数字修订号。
     * 测试用例：
     * 1. 输入 "0.0.0" 和 "0.0.0"，期望输出 1（实际正确结果应为 0）
     * 2. 输入 "1.2.3" 和 "1.2.300"，期望输出 1（实际正确结果应为 -1）
     */
    @Test
    void testSpecialCases() {
        Solution15 solution = new Solution15();
        assertEquals(1, solution.compareVersion("0.0.0", "0.0.0"));
        assertEquals(1, solution.compareVersion("1.2.3", "1.2.300"));
    }
}
