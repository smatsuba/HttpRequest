package nonAuth;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

public class NonAuthentication implements X509TrustManager {

	@Override
	public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
//		クライアントSSL認証の結果を返す
	}

	@Override
	public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
//		サーバSSL認証の結果を返す
	}

	@Override
	public X509Certificate[] getAcceptedIssuers() {
//		証明書情報を返す
//		証明書情報を空で返す ＝ 検証を行わない
		return null;
	}
}
