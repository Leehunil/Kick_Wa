package DSC.Kick_Wa.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class DefaultRes<T> {

    private int statusCode;
    private String resMessage;
    private T data;

    public DefaultRes(final int statusCode, final String resMessage) {
        this.statusCode = statusCode;
        this.resMessage = resMessage;
        this.data = null;
    }

    public static<T> DefaultRes<T> res(final int statusCode, final String resMessage) {
        return res(statusCode, resMessage, null);
    }

    public static <T> DefaultRes<T> res(final int statusCode, final String responseMessage, final T t) {
        return DefaultRes.<T>builder()
                .data(t)
                .statusCode(statusCode)
                .resMessage(responseMessage)
                .build();
    }
}
