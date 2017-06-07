/**
 * 
 */
package org.aposoft.wechat.company.managemnt.agent;

import java.util.Map;

import cn.aposoft.wechat.mp.WechatResp;

/**
 * <pre>
 * {
	   "errcode":"0",
	   "errmsg":"ok" ,
	   "agentid":"1" ,
	   "name":"NAME" ,
	   "square_logo_url":"xxxxxxxx" ,
	   "round_logo_url":"yyyyyyyy" ,
	   "description":"desc" ,
	   "allow_userinfos":{
	       "user":[
	             {
	                 "userid":"id1",
	                 "status":"1"
	             },
	             {
	                 "userid":"id2",
	                 "status":"1"
	             },
	             {
	                 "userid":"id3",
	                 "status":"1"
	             }
	              ]
	    },
	   "allow_partys":{
	       "partyid": [1]
	    },
	   "allow_tags":{
	       "tagid": [1,2,3]
	    }
	   "close":0 ,
	   "redirect_domain":"www.qq.com",
	   "report_location_flag":0,
	   "isreportuser":0,
	   "isreportenter":0,
	   "chat_extension_url":"http://www.qq.com",
	   "type":1
	}
 * </pre>
 * 
 * @author Jann Liu
 *
 */
public class AgentResp extends WechatResp {
	private static final long serialVersionUID = -3000102058715248386L;

	private String agentid;
	private String name;
	private String square_logo_url;
	private String round_logo_url;
	private String description;
	private String close;
	private String redirect_domain;
	private Integer report_location_flag;
	private Integer isreportuser;
	private Integer isreportenter;
	private String chat_extension_url;
	private Integer type;
	private Map<String, Integer[]> allow_partys;
	private Map<String, Integer[]> allow_tags;
	private Map<String, User[]> allow_userinfos;

	/**
	 * @return the agentid
	 */
	public String getAgentid() {
		return agentid;
	}

	/**
	 * @param agentid
	 *            the agentid to set
	 */
	public void setAgentid(String agentid) {
		this.agentid = agentid;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the square_logo_url
	 */
	public String getSquare_logo_url() {
		return square_logo_url;
	}

	/**
	 * @param square_logo_url
	 *            the square_logo_url to set
	 */
	public void setSquare_logo_url(String square_logo_url) {
		this.square_logo_url = square_logo_url;
	}

	/**
	 * @return the round_logo_url
	 */
	public String getRound_logo_url() {
		return round_logo_url;
	}

	/**
	 * @param round_logo_url
	 *            the round_logo_url to set
	 */
	public void setRound_logo_url(String round_logo_url) {
		this.round_logo_url = round_logo_url;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the close
	 */
	public String getClose() {
		return close;
	}

	/**
	 * @param close
	 *            the close to set
	 */
	public void setClose(String close) {
		this.close = close;
	}

	/**
	 * @return the redirect_domain
	 */
	public String getRedirect_domain() {
		return redirect_domain;
	}

	/**
	 * @param redirect_domain
	 *            the redirect_domain to set
	 */
	public void setRedirect_domain(String redirect_domain) {
		this.redirect_domain = redirect_domain;
	}

	/**
	 * @return the report_location_flag
	 */
	public Integer getReport_location_flag() {
		return report_location_flag;
	}

	/**
	 * @param report_location_flag
	 *            the report_location_flag to set
	 */
	public void setReport_location_flag(Integer report_location_flag) {
		this.report_location_flag = report_location_flag;
	}

	/**
	 * @return the isreportuser
	 */
	public Integer getIsreportuser() {
		return isreportuser;
	}

	/**
	 * @param isreportuser
	 *            the isreportuser to set
	 */
	public void setIsreportuser(Integer isreportuser) {
		this.isreportuser = isreportuser;
	}

	/**
	 * @return the isreportenter
	 */
	public Integer getIsreportenter() {
		return isreportenter;
	}

	/**
	 * @param isreportenter
	 *            the isreportenter to set
	 */
	public void setIsreportenter(Integer isreportenter) {
		this.isreportenter = isreportenter;
	}

	/**
	 * @return the chat_extension_url
	 */
	public String getChat_extension_url() {
		return chat_extension_url;
	}

	/**
	 * @param chat_extension_url
	 *            the chat_extension_url to set
	 */
	public void setChat_extension_url(String chat_extension_url) {
		this.chat_extension_url = chat_extension_url;
	}

	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * @return the allow_partys
	 */
	public Map<String, Integer[]> getAllow_partys() {
		return allow_partys;
	}

	/**
	 * @param allow_partys
	 *            the allow_partys to set
	 */
	public void setAllow_partys(Map<String, Integer[]> allow_partys) {
		this.allow_partys = allow_partys;
	}

	/**
	 * @return the allow_tags
	 */
	public Map<String, Integer[]> getAllow_tags() {
		return allow_tags;
	}

	/**
	 * @param allow_tags
	 *            the allow_tags to set
	 */
	public void setAllow_tags(Map<String, Integer[]> allow_tags) {
		this.allow_tags = allow_tags;
	}

	/**
	 * @return the allow_userinfos
	 */
	public Map<String, User[]> getAllow_userinfos() {
		return allow_userinfos;
	}

	/**
	 * @param allow_userinfos
	 *            the allow_userinfos to set
	 */
	public void setAllow_userinfos(Map<String, User[]> allow_userinfos) {
		this.allow_userinfos = allow_userinfos;
	}

	/**
	 * @author Jann Liu
	 *
	 */
	public static class User {
		private String userid;
		private String status;

		/**
		 * @return the userid
		 */
		public String getUserid() {
			return userid;
		}

		/**
		 * @param userid
		 *            the userid to set
		 */
		public void setUserid(String userid) {
			this.userid = userid;
		}

		/**
		 * @return the status
		 */
		public String getStatus() {
			return status;
		}

		/**
		 * @param status
		 *            the status to set
		 */
		public void setStatus(String status) {
			this.status = status;
		}
	}
}
