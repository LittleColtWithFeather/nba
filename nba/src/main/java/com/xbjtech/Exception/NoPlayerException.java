package com.xbjtech.Exception;
/**
 * @author Ma Yucheng
 * @date 2019-3-31- 17:24:48
 * @version 1.0
 * @desc 球员库没有球员的异常
 */
public class NoPlayerException extends RuntimeException {
	
	public NoPlayerException(String message) {
		super(message);
	}

}
