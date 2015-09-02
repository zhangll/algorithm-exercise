package com.zhangll.lib.algorithm.recursive;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 串串字连环
 * 
 * 时间复杂度: 
 *
 * @author zhangll
 */
public class Boggle {

//	private static String[][] charMatrix = new String[][] {
//			{ "N", "N", "N", "N", "S" }, 
//			{ "N", "E", "E", "E", "N" },
//			{ "N", "E", "Y", "E", "N" }, 
//			{ "N", "E", "E", "E", "N" },
//			{ "N", "N", "N", "N", "N" }, 
//	};
//	
	private static String[][] charMatrix = new String[][] {
                { "U", "R", "L", "P", "M" }, 
                { "X", "P", "R", "E", "T" },
                { "G", "I", "A", "E", "T" }, 
                { "X", "T", "N", "Z", "Y" },
                { "X", "O", "Q", "R", "S" }, 
	};

	@Test
	public void testHasWord() throws Exception {
//		assertEquals(true, hasWord(2, 2, "yes"));
//		assertEquals(true, hasWord(2, 2, "yen"));
//		assertEquals(false, hasWord(2, 2, "NYS"));

		assertEquals(true, hasWord(1, 1, "PRETTY"));
		assertEquals(true, hasWord(2, 0, "GIRL"));
		assertEquals(true, hasWord(0, 3, "REPEAT"));
	}
	
	private static boolean hasWord(int y, int x, String word) {
		String leftWord = word.substring(1, word.length()); //每找到一个字符就前进一步, 减少一个字符.
		if (leftWord.length() == 0) { //递归终止条件, 如果要查找的字符都找到了, 也就是剩下的单词为空, 那么递归结束 返回true
			return true;
		}
		
		String nextChar = leftWord.substring(0, 1); //下一个要找的字符

		//上
		if (moveable(y-1, x, nextChar)){ // 向上走一格
			if(hasWord(y-1, x, leftWord)){// 如果向上可以走, 递归一直往上查找剩下的字符
				return true; //这个返回不是终止条件, 是内层递归方法向上返回
			}
		} 
		//右上
        if (moveable(y-1, x+1, nextChar)) {
			if(hasWord(y-1,x+1, leftWord)){
				return true;
			}
		}
		//右
        if (moveable(y, x+1, nextChar)) {
            if(hasWord(y, x+1, leftWord)){
            	return true;
            }
        }
		//右下
        if (moveable(y+1, x+1, nextChar)) {
            if(hasWord(y+1, x+1, leftWord)){
            	return true;
            }
        }
		//下
        if (moveable(y+1, x, nextChar)) {
            if(hasWord(y+1, x, leftWord)){
            	return true;
            }
        }
		//左下
        if (moveable(y+1, x-1, nextChar)) {
            if(hasWord(y+1, x-1, leftWord)){
            	return true;
            }
        }
		//左
        if (moveable(y, x-1, nextChar)) {
            if(hasWord(y, x-1, leftWord)){
            	return true;
            }
        }
		//左上
        if (moveable(y-1, x-1, nextChar)) {
            if(hasWord(y-1, x-1, leftWord)){
            	return true;
            }
        }
		return false;
	}

	private static boolean moveable(int y, int x, String nextChar) {
		if (x < 0 || x > 4) {
			return false;
		}
		if (y < 0 || y > 4) {
			return false;
		}
		if (!charMatrix[y][x].equalsIgnoreCase(nextChar)) {
			return false;
		}
		return true;
	}

}
