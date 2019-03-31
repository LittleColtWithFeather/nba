package com.xbjtech.Exception;
/**
 * @author Ma Yucheng
 * @date 2019年3月31日 下午5:24:48
 * @version 1.0
 * @desc 球员库没有球员的异常
 */
public class NoPlayerException extends RuntimeException {
	
	public NoPlayerException(String message) {
		super(message);
	}

}
