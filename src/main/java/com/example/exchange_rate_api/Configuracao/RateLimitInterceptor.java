package com.example.exchange_rate_api.Configuracao;

import io.github.bucket4j.Bucket;
import io.github.bucket4j.BucketConfiguration;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@RequiredArgsConstructor
@Component
public class RateLimitInterceptor implements HandlerInterceptor {

    private final BucketConfiguration bucketConfiguration;

    private final Map<String, Bucket> buckets =
            new ConcurrentHashMap<>();

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {

        String ip = request.getRemoteAddr();

        Bucket bucket = buckets.computeIfAbsent(
                ip,
                this::criarBucket
        );

        if (!bucket.tryConsume(1)) {

            response.setStatus(429);
            response.getWriter()
                    .write("Limite de requisições excedido");

            return false;
        }

        return true;
    }

    private Bucket criarBucket(String ip) {

        return Bucket.builder()
                .addLimit(
                        bucketConfiguration.getBandwidths()[0]
                )
                .build();
    }
}
