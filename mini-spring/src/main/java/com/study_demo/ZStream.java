package com.study_demo;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description
 * @Author Zhang hao yu
 * @Date 2025/2/14 11:09
 */
public class ZStream<T> {
    private final Stream<T> stream;

    private ZStream(Stream<T> stream) {
        this.stream = stream;
    }

    public static <T> ZStream<T> of(Collection<T> collection) {
        return new ZStream<>(collection.stream());
    }

    public void foreach(Consumer<T> consumer) {
        stream.forEach(consumer);
    }

    public List<T> toList() {
        return stream.collect(Collectors.toList());
    }

    public ZStream<T> where(Predicate<? super T> predicate) {
        return new ZStream<>(stream.filter(predicate));
    }

    public <R> ZStream<T> whereNotNull(Function<T, R> function) {
        return new ZStream<>(filterNotNull(function));
    }

    private <R> Stream<T> filterNotNull(Function<T, R> function) {
        return stream.filter(item -> {
            R r = function.apply(item);
            if (r == null) {
                return false;
            }

            if (r instanceof String) {
                return !"".equals(r);
            }
            return true;
        });
    }
}
