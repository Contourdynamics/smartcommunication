package org.contourdynamics.cms.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;
import org.contourdynamics.cms.Entities.BpMain;
import org.contourdynamics.cms.producers.MainEMResolver;

@ApplicationScoped
@Repository(forEntity = BpMain.class)
@EntityManagerConfig(entityManagerResolver = MainEMResolver.class)
public interface BpMainRepos extends EntityRepository<BpMain, Integer> {
//public abstract class BpMainRepos  extends AbstractEntityRepository<BpMain, Integer> {
	
//	@Query(value = "select BPM.id,BPM.description,BPM.type,BPM.StatusCode,BPM.BP_SYS_User from BP_Main BPM LEFT join BP_Roles BPR ON BPR.BP_Main = BPM.id where BPR.Role = ?1", isNative = true)
//	QueryResult<BpMain> findAllCustomers(int role);
	
//	@Query(value = "select BPM from BPMain BPM where BPM.BpRoleses.")
//	QueryResult<BpMain> findAllCustomer(int role);
	
//	List<BpMain> findByBpRoleses_RoleCode_Id(int role);
	

    @Query("select BPM from BpMain BPM where BPM.id IN (select BPM.id from BPM.bpRoleses bpr where bpr.roleCode.id= ?1)")
    List<BpMain> findAllCustomer(int role);
	
}
