package models.modules.mobile;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alipay.api.domain.Condition;

import play.db.jpa.GenericModel;
import utils.jpa.SQLResult;

@Entity
@Table(name = "xjl_sc_config")
public class XjlScConfig extends GenericModel {
	//学校id
	@Column(name = "school_id")
	public String schoolId;
	//冲水感应id
	@Id
	@Column(name = "id")
	public Long id;
	//10:5-12:20格式，开始时间-结束时间，具体到分钟
	@Column(name = "time_quantum")
	public String timeQuantum;
	//时间间隔，隔多长时间冲一次水，单位为分钟
	@Column(name = "interval")
	public String interval;
	//是不是离开时候冲水
	@Column(name = "leave_rush")
	public String leaveRush;
	
	@Column(name = "STATUS")
	public String status;
	//配置类型1:感应时间段，2：冲水间隔，3:驱蚊驱味，4:灯管感应时间设置，5:排风扇时间设置
	@Column(name = "CONFIG_STATUS")
	public String configStatus;

	@Column(name = "CREATE_TIME")
	public Date createTime;
	/**
	 * 把schoolId添加到查询条件中
	 * @param schoolId
	 * @param condition
	 */
	private static Map<String, String> addSchoolId(Long schoolId,Map<String, String> condition) {
		if (condition == null) {
			condition = new HashMap<String,String>();
		}
		condition.put("schoolId", ""+schoolId);
		return condition;
	}
	public static Map query(Long schoolId,Map<String, String> condition,
			int pageIndex, int pageSize){
		String sql = "select * from xjl_sc_config where status = '0AA' and CONFIG_STATUS='1' order by time_quantum asc";
		condition = addSchoolId(schoolId, condition);
		SQLResult ret = ModelUtils.createSQLResult(condition, sql);
		List<XjlScConfig> data = ModelUtils.queryData(pageIndex, pageSize, ret,XjlScConfig.class);
		return ModelUtils.createResultMap(ret, data);
	}
	
	public static Map queryNotTime(Long schoolId,Map<String, String> condition,
			int pageIndex, int pageSize){
		String sql = "select * from xjl_sc_config where status ='0AA' and interval is null order by create_time desc";
		condition = addSchoolId(schoolId, condition);
		SQLResult ret = ModelUtils.createSQLResult(condition, sql);
		List<XjlScConfig> data = ModelUtils.queryData(pageIndex, pageSize, ret,XjlScConfig.class);
		return ModelUtils.createResultMap(ret, data);
	}
	
	public static Map queryInterval(Long schoolId,Map<String, String> condition,
			int pageIndex, int pageSize){
		String sql = "select * from xjl_sc_config where status='0AA' and config_status='2' order by time_quantum asc";
		condition = addSchoolId(schoolId, condition);
		SQLResult ret = ModelUtils.createSQLResult(condition, sql);
		List<XjlScConfig> data = ModelUtils.queryData(pageIndex, pageSize, ret,XjlScConfig.class);
		return ModelUtils.createResultMap(ret, data);
	}
	
	public static Map queryMosq(Long schoolId,Map<String, String> condition,
			int pageIndex, int pageSize){
		String sql="select * from xjl_sc_config where status='0AA' and  config_status='3' order by time_quantum asc";
		condition = addSchoolId(schoolId, condition);
		SQLResult ret = ModelUtils.createSQLResult(condition, sql);
		List<XjlScConfig> data = ModelUtils.queryData(pageIndex, pageSize, ret,XjlScConfig.class);
		return ModelUtils.createResultMap(ret, data);
	}
	
	public static Map queryLam(Long schoolId,Map<String, String> condition,
			int pageIndex, int pageSize){
		String sql="select * from xjl_sc_config where status='0AA' and  config_status='4' order by time_quantum asc";
		condition = addSchoolId(schoolId, condition);
		SQLResult ret = ModelUtils.createSQLResult(condition, sql);
		List<XjlScConfig> data = ModelUtils.queryData(pageIndex, pageSize, ret,XjlScConfig.class);
		return ModelUtils.createResultMap(ret, data);
	}
	
	public static Map queryVen(Long schoolId,Map<String, String> condition,
			int pageIndex, int pageSize){
		String sql="select * from xjl_sc_config where status='0AA' and  config_status='5' order by time_quantum asc";
		condition = addSchoolId(schoolId, condition);
		SQLResult ret = ModelUtils.createSQLResult(condition, sql);
		List<XjlScConfig> data = ModelUtils.queryData(pageIndex, pageSize, ret,XjlScConfig.class);
		return ModelUtils.createResultMap(ret, data);
	}
	
	public static int modifyInterval(Long schoolId,String timeQuantum,String interval){
		String sql = "update xjl_sc_config set interval='"+interval+"' where time_quantum = '"+timeQuantum+"' and school_id='" + schoolId + "'";
		Map<String, String> condition = new HashMap<String, String>();
		return ModelUtils.executeDelete(condition, sql);
	}
	
	public static int modifyTimeQuanTumById(String timeQuanTum,String id){
		String sql = "update xjl_sc_config set time_quantum = '"+timeQuanTum+"' where id='"+id+"'";
		Map<String, String> condition = new HashMap<String, String>();
		return ModelUtils.executeDelete(condition, sql);
	}
	
	public  static int  modifyIntervalById(String timeQuanTum ,String interval,String id){
		String sql = "update xjl_sc_config set time_quantum='"+timeQuanTum+"', interval='"+interval+"' where id='"+id+"'";
		Map<String, String> condition = new HashMap<String, String>();
		return ModelUtils.executeDelete(condition, sql);
	}
	
	public static int modifyIntervalIsNull(Long id){
		String sql = "update xjl_sc_config set status='0XX' where id = '"+id+"'";
		Map<String, String> condition = new HashMap<String, String>();
		return ModelUtils.executeDelete(condition, sql);
	}
	public static int modifyStatus(Long id){
		String sql = "update xjl_sc_config set status='0XX' where id='"+id+"'";
		Map<String, String> condition = new HashMap<String, String>();
		return ModelUtils.executeDelete(condition, sql);
	}
	
	
	public static int modifyLeaveRush(Long schoolId,String leaveRush){
		String sql = "update xjl_sc_config set leave_rush='"+leaveRush+"' where status='0AA' and  config_status='1' and school_id='"+schoolId+"'";
		Map<String, String> condition = new HashMap<String, String>();
		return ModelUtils.executeDelete(condition, sql);
	}
 
	
	public static XjlScConfig queryScConfigById(Long id){
		String sql = "select * from xjl_sc_config where id='"+id+"'";
		Map<String, String> condition = new HashMap<String, String>();
		SQLResult ret = ModelUtils.createSQLResult(condition, sql);
		List<XjlScConfig> data = ModelUtils.queryData(1, -1, ret,XjlScConfig.class);
		if(data.isEmpty()){
			return null;
		}
		return data.get(0);
	}
	
	
}
