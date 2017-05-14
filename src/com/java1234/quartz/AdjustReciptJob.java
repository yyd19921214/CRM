package com.java1234.quartz;

import com.java1234.service.ReciptService;

public class AdjustReciptJob {
	private ReciptService reciptService;

	public void setReciptService(ReciptService reciptService) {
		this.reciptService = reciptService;
	}
	
	public void work(){
		reciptService.adjustProduct();
	}
	

}
