package eu.saramak.guava.test;

import com.google.common.base.Optional;

public class OptionalApi {
	public Optional<String> getVersion() {
		return Optional.<String>absent();
	}
	public int getSize(){
		return 0;
	}
}