package shorts.zimply.com.zimplyshorts.managers;

public interface GetRequestListener {

	void onRequestStarted(String requestTag);

	void onRequestCompleted(String requestTag, Object obj);

	void onRequestFailed(String requestTag, Object obj);
}
