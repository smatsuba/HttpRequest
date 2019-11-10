package test;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

public class NonAuthentication implements X509TrustManager {

	@Override
	public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public X509Certificate[] getAcceptedIssuers() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
