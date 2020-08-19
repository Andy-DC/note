package com.demo.common.util;

public class ResultView {
    //返回操作提示结果(success:1,fail:0)
    private int Result;
    //返回的结果对象
    private Object Info;
    //返回操作提示信息
    private String ResultMessage;
    
	public int getResult() {
		return Result;
	}

	public void setResult(int result) {
		Result = result;
	}

	public Object getInfo() {
		return Info;
	}

	public void setInfo(Object info) {
		Info = info;
	}

	public String getResultMessage() {
		return ResultMessage;
	}

	public void setResultMessage(String resultMessage) {
		ResultMessage = resultMessage;
	}

	public static ResultView GetResult(Object info, int result, String resultMessage) {
		return new ResultView(result,info,resultMessage);
    }

	public ResultView() {
		super();
	}

	public ResultView(int result, Object info, String resultMessage) {
		super();
		Result = result;
		Info = info;
		ResultMessage = resultMessage;
	}
}