
	public static void main(String[] args) {
		SpringApplication.run(BmwApplication.class, args);
	}

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BmwApplication.class);
    }

}
