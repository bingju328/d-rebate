package com.drebate.model.datamodel;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapBuilder {
	
	public static <S, T> List<T> copyAndConvert(Page<S> page, Function<S, T> function) {
		List<T> result = page.getList().stream().map(v -> function.apply(v)).collect(Collectors.toList());
		return result;
	}
	public static <S, T> List<T> copyAndConvert(List<S> list, Function<S, T> function) {
		List<T> result = list.stream().map(v -> function.apply(v)).collect(Collectors.toList());
		return result;
	}

}
