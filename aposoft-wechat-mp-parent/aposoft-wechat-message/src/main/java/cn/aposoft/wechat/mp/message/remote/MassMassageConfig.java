/**
 * 
 */
package cn.aposoft.wechat.mp.message.remote;

/**
 * @author Jann Liu
 *
 */
public final class MassMassageConfig {
	private MassMassageConfig() {
	}

	/**
	 * <pre>
	 * 开发者调用群发接口进行图文消息的群发时，微信会将开发者准备群发的文章，与公众平台原创库中的文章进行比较，校验结果分为以下几种：
		1. 当前准备群发的文章，未命中原创库中的文章，则可以群发。
		2. 当前准备群发的文章，已命中原创库中的文章，则：
		2.1 若原创作者允许转载该文章，则可以进行群发。群发时，会自动替换成原文的样式，且会自动将文章注明为转载并显示来源。
		      若希望修改原文内容或样式，或群发时不显示转载来源，可自行与原创公众号作者联系并获得授权之后再进行群发。
		2.2 若原创作者禁止转载该文章，则不能进行群发。   
		      若希望转载该篇文章，可自行与原创公众号作者联系并获得授权之后再进行群发。
	 * </pre>
	 * 
	 * <pre>
	 * 	群发接口新增 send_ignore_reprint 参数，开发者可以对群发接口的 send_ignore_reprint 参数进行设置，指定待群发的文章被判定为转载时，是否继续群发。
		当 send_ignore_reprint 参数设置为1时，文章被判定为转载时，且原创文允许转载时，将继续进行群发操作。
		当 send_ignore_reprint 参数设置为0时，文章被判定为转载时，将停止群发操作。
		send_ignore_reprint 默认为0。
	 * </pre>
	 */
	public static final String SEND_IGNORE_REPRINT = "send_ignore_reprint ";
	/**
	 * <pre>
	 * 使用 clientmsgid 参数，避免重复推送
		一、群发接口新增 clientmsgid 参数，开发者调用群发接口时可以主动设置 clientmsgid 参数，避免重复推送。
		群发时，微信后台将对 24 小时内的群发记录进行检查，如果该 clientmsgid 已经存在一条群发记录，则会拒绝本次群发请求，返回已存在的群发msgid，开发者可以调用“查询群发消息发送状态”接口查看该条群发的状态。
	 * </pre>
	 */
	public static final String CLIENT_MSG_ID = "clientmsgid";
}
