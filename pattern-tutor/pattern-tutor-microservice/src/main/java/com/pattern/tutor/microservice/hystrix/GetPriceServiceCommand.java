package com.pattern.tutor.microservice.hystrix;

import com.netflix.hystrix.*;
import com.pattern.tutor.microservice.hystrix.service.PriceService;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author buildupchao
 *         Date: 2019/3/19 00:47
 * @since JDK 1.8
 */
public class GetPriceServiceCommand extends HystrixCollapser<List<Double>, Double, Long> {

    private PriceService priceService;
    private Long id;

    public GetPriceServiceCommand(PriceService priceService, Long id) {
        super(setter());
        this.priceService = priceService;
        this.id = id;
    }

    @Override
    public Long getRequestArgument() {
        return id;
    }

    @Override
    protected HystrixCommand<List<Double>> createCommand(Collection<CollapsedRequest<Double, Long>> requests) {
        return new BatchPriceCommand(priceService, requests);
    }

    @Override
    protected void mapResponseToRequests(List<Double> batchResponse, Collection<CollapsedRequest<Double, Long>> requests) {
        final AtomicInteger count = new AtomicInteger(0);
        requests.forEach(request -> {
            request.setResponse(batchResponse.get(count.getAndIncrement()));
        });
    }

    private static HystrixCollapser.Setter setter() {
        return HystrixCollapser.Setter
                .withCollapserKey(HystrixCollapserKey.Factory.asKey("price"))
                .andCollapserPropertiesDefaults(HystrixCollapserProperties.Setter()
                        .withMaxRequestsInBatch(2)
                        .withTimerDelayInMilliseconds(5)
                        .withRequestCacheEnabled(true)
                ).andScope(Scope.REQUEST);
    }

    static class BatchPriceCommand extends HystrixCommand<List<Double>> {

        private PriceService priceService;
        private Collection<CollapsedRequest<Double, Long>> requests;

        public BatchPriceCommand(PriceService priceService,
                                 Collection<CollapsedRequest<Double, Long>> requests) {
            super(setter());
            this.priceService = priceService;
            this.requests = requests;
        }

        private static Setter setter() {
            return Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("price"));
        }

        @Override
        protected List<Double> run() throws Exception {
            List<Long> ids = requests.stream().map(request -> request.getArgument()).collect(Collectors.toList());
            return priceService.getPrices(ids);
        }
    }
}
