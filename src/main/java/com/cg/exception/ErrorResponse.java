package com.cg.exception;

import java.time.LocalDateTime;

//@Data
//	@Builder
//	@NoArgsConstructor
//	@AllArgsConstructor
	public class ErrorResponse {

	    private LocalDateTime timestamp;
	    private int status;
	    private String error;
	    private String message;
	    private String path;
		public static Object builder() {
			// TODO Auto-generated method stub
			return null;
		}
	}