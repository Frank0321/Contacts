
// 給@CreateBy 使用的
public class AuditorAwareImpl implements AuditorAware<String> {

@Override
public Optional<String> getCurrentAuditor() {
return ofNullable(SecurityContextHolder.getContext().getAuthentication())
.map(Authentication::getPrincipal)
.filter(UserDetails.class::isInstance)
.map(UserDetails.class::cast)
.map(UserDetails::getUsername);
}
}



//呼叫 AuditorAwareImpl
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories(basePackages = "tw.com.softleader.ri", repositoryFactoryBeanClass = RiJpaRepositoryFactoryBean.class, excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "tw.com.softleader.ri.finance..*Repository"))
public class PersistenceConfig {

@Bean
public AuditorAware<String> auditorAware() {
return new AuditorAwareImpl();
}
}