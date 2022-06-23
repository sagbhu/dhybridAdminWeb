package com.productmanagement.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.productmanagement.constant.ProductServiceConstants;
import com.productmanagement.service.ProductCategoryService;
import com.productmanagement.service.ProductService;

@Component
public class ProductScheduler {

	private static final Logger logger = LoggerFactory.getLogger(ProductScheduler.class);

	@Autowired
	ProductService productService;

	@Autowired
	ProductCategoryService productCategoryService;

	@Scheduled(cron = ProductServiceConstants.PRODUCT_CRON)
	public void syncProductsWithVinculum() {
		logger.debug("updateProducts method start in ProductScheduler");
		productService.syncProductsWithVinculum(null, true);
		logger.debug("updateProducts method end in ProductScheduler");
	}

	@Scheduled(cron = ProductServiceConstants.PRODUCT_CATEGORY_CRON)
	public void syncProductsCategoriesWithVinculum() {
		logger.debug("updateCategories method start in ProductScheduler");
		productCategoryService.syncProductsCategoriesWithVinculum(null, true);
		logger.debug("updateCategories method end in ProductScheduler");
	}
}
