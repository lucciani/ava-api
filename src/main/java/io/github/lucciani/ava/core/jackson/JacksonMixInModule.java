package io.github.lucciani.ava.core.jackson;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.module.SimpleModule;

@Component
public class JacksonMixInModule extends SimpleModule{

	private static final long serialVersionUID = -7877192298862120856L;
	
	public JacksonMixInModule() {
	}

}
