/**
 * 
 */
package org.aposoft.wechat.company.managemnt.agent;

import java.io.Serializable;

/**
 * <pre>
 *   {
           "agentid": "5",
           "name": "企业小助手",
           "square_logo_url": "url",
           "round_logo_url": "url"
       },
 * </pre>
 * 
 * @author Jann Liu
 *
 */
public class Agent implements Serializable {
	private static final long serialVersionUID = -445307429446895199L;
	private String agentid;
	private String name;
	private String square_logo_url;
	private String round_logo_url;

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

}
