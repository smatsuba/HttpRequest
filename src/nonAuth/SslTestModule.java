package nonAuth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public class SslTestModule {

	public static void main(String[] args) throws Exception {
		SSLSocketFactory factory = null;
		SSLContext ctx = SSLContext.getInstance("TLS");
		ctx.init(null, new NonAuthentication[] { new NonAuthentication() }, null);
		factory = ctx.getSocketFactory();

//		bad ssl
//		URL url = new URL("https://expired.badssl.com/");
//		URL url = new URL("https://wrong.host.badssl.com/");	// Error: No subject alternative DNS name matching wrong.host.badssl.com found.
//		URL url = new URL("https://self-signed.badssl.com/");
//		URL url = new URL("https://untrusted-root.badssl.com/");
//		URL url = new URL("https://revoked.badssl.com/");
//		URL url = new URL("https://pinning-test.badssl.com/");

//		normal ssl
		URL url = new URL("https://example.com/");
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		con.setSSLSocketFactory(factory);

		System.out.println("----- Headers -----");
		Map<String, List<String>> headers = con.getHeaderFields();
		for (String key : headers.keySet()) {
			System.out.println(key + ": " + headers.get(key));
		}
		System.out.println();

		System.out.println("----- Body -----");
		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String body;
		while ((body = reader.readLine()) != null) {
			System.out.println(body);
		}

		reader.close();
		con.disconnect();
	}
}