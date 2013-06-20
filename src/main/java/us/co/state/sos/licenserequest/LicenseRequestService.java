package us.co.state.sos.licenserequest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LicenseRequestService {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public String create(LicenseRequest licenseRequest) {
		System.out.format("License for %s accepted", licenseRequest.getLastName());
		entityManager.persist(licenseRequest);
		return "Success";
	}
	
	public LicenseRequest load(Long id) {
		return entityManager.find(LicenseRequest.class, id);
	}
	
	public List<LicenseRequest> getList(){
		TypedQuery<LicenseRequest> query =  entityManager.createQuery("SELECT a from LicenseRequest as a", LicenseRequest.class);
		
		return query.getResultList();
	}
}
