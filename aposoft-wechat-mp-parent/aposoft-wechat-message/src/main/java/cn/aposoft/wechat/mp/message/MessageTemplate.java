/**
 * 
 */
package cn.aposoft.wechat.mp.message;

/**
 * 消息模板
 * 
 * <pre>
 * {	
 "template_list": [{
      "template_id": "iPk5sOIt5X_flOVKn5GrTFpncEYTojx6ddbt8WYoV5s",
      "title": "领取奖金提醒",
      "primary_industry": "IT科技",
      "deputy_industry": "互联网|电子商务",
      "content": "{ {result.DATA} }\n\n领奖金额:{ {withdrawMoney.DATA} }\n领奖  时间:{ {withdrawTime.DATA} }\n银行信息:{ {cardInfo.DATA} }\n到账时间:  { {arrivedTime.DATA} }\n{ {remark.DATA} }",
      "example": "您已提交领奖申请\n\n领奖金额：xxxx元\n领奖时间：2013-10-10 12:22:22\n银行信息：xx银行(尾号xxxx)\n到账时间：预计xxxxxxx\n\n预计将于xxxx到达您的银行卡"
   }]
	}
 * </pre>
 * 
 * <pre>
 * 	access_token		是	接口调用凭证
	template_id			是	模板ID
	title				是	模板标题
	primary_industry	是	模板所属行业的一级行业
	deputy_industry		是	模板所属行业的二级行业
	content				是	模板内容
	example				是	模板示例
 * </pre>
 * 
 * @author Jann Liu
 *
 */
public class MessageTemplate {
	private String template_id;
	private String title;
	private String primary_industry;
	private String deputy_industry;
	private String content;
	private String example;

	/**
	 * @return the template_id
	 */
	public String getTemplate_id() {
		return template_id;
	}

	/**
	 * @param template_id
	 *            the template_id to set
	 */
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the primary_industry
	 */
	public String getPrimary_industry() {
		return primary_industry;
	}

	/**
	 * @param primary_industry
	 *            the primary_industry to set
	 */
	public void setPrimary_industry(String primary_industry) {
		this.primary_industry = primary_industry;
	}

	/**
	 * @return the deputy_industry
	 */
	public String getDeputy_industry() {
		return deputy_industry;
	}

	/**
	 * @param deputy_industry
	 *            the deputy_industry to set
	 */
	public void setDeputy_industry(String deputy_industry) {
		this.deputy_industry = deputy_industry;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the example
	 */
	public String getExample() {
		return example;
	}

	/**
	 * @param example
	 *            the example to set
	 */
	public void setExample(String example) {
		this.example = example;
	}

}
