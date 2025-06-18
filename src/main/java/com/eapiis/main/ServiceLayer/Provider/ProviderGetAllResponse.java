package com.eapiis.main.ServiceLayer.Provider;

import java.util.ArrayList;
import java.util.List;

import com.eapiis.main.Entity.Provider;

public class ProviderGetAllResponse {
	public static class Dto {
		public List<Provider> listProvider = new ArrayList<>();
	}

	public Dto dto = new Dto();
}