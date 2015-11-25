package ui.login;

import util.AccountType;

/**
 * 负责登录界面跳转
 * 
 * @author czq
 * @version 2015年11月25日 下午8:12:19
 */
public class LoginJump {

	AccountType type;

	public LoginJump(AccountType type) {
		this.type = type;
		jump();

	}

	private void jump() {
		switch (type) {
		case Adminstrator:

			break;
		case courier:

			break;
		case financeman:

			break;
		case manager:

			break;
		case saleman:

			break;
		case storeman:

			break;
		case storemanager:

			break;
		default:
			break;
		}

	}

}
