package auth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class SslTestModuleAuth {
	public static void main(String[] args) throws Exception {

//		bad ssl
//		URL url = new URL("https://expired.badssl.com/");		// PKIX path validation failed, validity check failed
//		URL url = new URL("https://wrong.host.badssl.com/");	// No subject alternative DNS name matching wrong.host.badssl.com found.
//		URL url = new URL("https://self-signed.badssl.com/");	// unable to find valid certification path to requested target
//		URL url = new URL("https://untrusted-root.badssl.com/");	// unable to find valid certification path to requested target
//		URL url = new URL("https://revoked.badssl.com/");		// いけてしまう！
//		URL url = new URL("https://pinning-test.badssl.com/");	// いけてしまう！

//		valid ssl
		URL url = new URL("https://sha256.badssl.com/");		// もちろんいける！
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

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
