package com.dhybrid.admin.constant;

public interface URLConstants {

	String FETCH_PRODUCT_URL = "http://localhost:8082/productService/getProducts";

	String FETCH_PRODUCT_LIST_URL = "http://localhost:8082/productService/products";

	String CREATE_PRODUCT_SLUG = "http://localhost:8082/productService/createProductSlug";

	String FETCH_PRODUCTSLUG_URL = "http://localhost:8082/productService/productSlugList";

	String UPDATE_PRODUCTSLUG_URL = "http://localhost:8082/productService/updateProductSlug";

	String UPDATE_PRODUCTS_URL = "http://localhost:8082/productService/updateProducts";

	String DELETE_PRODUCTSLUG_URL = "http://localhost:8082/productService/deleteProductSlug";

	String USER_AUTHENTICATE_URL = "http://localhost:8080/userservice/authenticate";

	String CREATE_PRODUCT_LABEL = "http://localhost:8082/productService/product/label/create";

	String FETCH_PRODUCT_LABEL = "http://localhost:8082/productService/product/label/list";

	String UPDATE_PRODUCT_LABEL = "http://localhost:8082/productService/product/label/update";

	String DELETE_PRODUCT_LABEL = "http://localhost:8082/productService/product/label/delete";

	String LOGIN = "http://localhost:8080/userService/login";

	String FETCH_SINGLE_BLOG_URL = "http://localhost:8083/blogService/getBlogs";

	String FETCH_BLOG_LIST_URL = "http://localhost:8083/blogService/getBlogs";

	String CREATE_BLOG_LIST_URL = "http://localhost:8083/blogService/createBlog";

	String UPDATE_BLOG_LIST_URL = "http://localhost:8083/blogService/updateBlog";

	String DELETE_BLOG_URL = "http://localhost:8083/blogService/deleteBlog";

	String FETCH_CONTENT_LIST_URL = "http://localhost:8083/contentService/getContent";

	String FETCH_BLOG_CATEGORY_LIST_URL = "http://localhost:8083/blogService/getCategories";

	String CREATE_USER_URL = "http://localhost:8080/userService/createUser";

	String UPDATE_USER_URL = "http://localhost:8080/userService/updateUser";

	String DELETE_USER_URL = "http://localhost:8080/userService/delete";

	String FETCH_USERS_URL = "http://localhost:8080/userService/users";

	String FETCH_SINGLE_USER_URL = "http://localhost:8080/userService/user";

	String CREATE_ROLE_URL = "http://localhost:8080/userService/role";

	String UPDATE_ROLE_URL = "http://localhost:8080/userService/role";

	String DELETE_ROLE_URL = "http://localhost:8080/userService/role";

	String FETCH_ROLES_URL = "http://localhost:8080/userService/roles";

	String FETCH_SINGLE_ROLE_URL = "http://localhost:8080/userService/role";

	String CREATE_ROLE_PERMISSIONS_URL = "http://localhost:8080/userService/role-permission";

	String UPDATE_ROLE_PERMISSIONS_URL = "http://localhost:8080/userService/role-permission";

	String DELETE_ROLE_PERMISSIONS_URL = "http://localhost:8080/userService/role-permission/";

	String FETCH_ROLES_PERMISSIONS_URL = "http://localhost:8080/userService/role-permission/list";

	String FETCH_SINGLE_ROLE_PERMISSIONS_URL = "http://localhost:8080/userService/role-permission/";

	String UPDATE_UPLOAD_BLOG_IMAGES_URL = "http://localhost:8083/blogService/updateBlogImages";
}
