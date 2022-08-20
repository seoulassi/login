package com.webapp.webhome.common.response;

public enum StatusEnum {

    /**
        100 : 정보 전송
        200 : 성공
        300 : 리다이렉션
        400 : 클라이언트 오류
        500 : 서버 오류
     */

    /** 200 성공
        200: Ok, 클라이언트의 요청을 정상적으로 수행함.
        201: Created, 클라이언트에게 생성 작업을 요청받았고, 생성 작업을 성공함.
        204: No Content, 요청은 성공했으나 응답할 콘텐츠가 없음.
        205: Reset Content, 요청은 성공했으나 클라이언트의 화면을 새로 고침하도록 권고
        206: Partial Content, 요청은 성공했으나 일부 범위의 데이터만 반환함.
    */
    OK(200, "OK"),
    CREATED(201, "CREATED"),
    NO_CONTENT(204, "NO_CONTENT"),
    RESET_CONTENT(205, "RESET_CONTENT"),
    PARTIAL_CONTENT(206, "PARTIAL_CONTENT"),

    /** 300 리다이렉션
        301: Moved Permantly, 클라이언트가 요청한 리소스에 대한 URI가 영구적으로 변경되었음을 의미.
        302: Found, 요청한 URI가 일시적으로 주소가 바뀌었을 경우를 의미.
        303: See Other, 요청한 자원이 임시 주소에 존재함.
        304: Not Modified, 이전에 방문했을 때의 요청 결과와 다르지 않을 경우(캐시 된 페이지를 그대로 사용)
        307: Temporary Redirect, 임시 페이지로 리다이렉트. 
    */
    MOVED_PERMANTHLY(301, "MOVED_PERMANTHLY"),
    FOUND(302, "FOUND"),
    SEE_OTHER(303, "SEE_OTHER"),
    NOT_MODIFIED(304, "NOT_MODIFIED"),
    TEMPORARY_REDIRECT(307, "TEMPORARY_REDIRECT"),

    /** 400 클라이언트 오류
        400: Bad Request, 클라이언트가 올바르지 못한 요청을 보냄.
        401: Unauthorized, 인증 혹은 승인되지 않은 접근(로그인을 하지 않아 페이지를 열 권한이 없음)
        403: Forbidden, 금지된 페이지, 로그인을 하든 안하든 접근할 수 없음. (관리자 페이지)
        404: Not found, 찾을 수 없는 페이지, 주소를 잘 못 입력했을 때 사용함.인증받지 않은 클라이언트로 부터 리소스를 숨기기 위해 403 대신에 사용할 수도 있음.(해커들의 공격을 방지하고자 페이지가 없는 것처럼 위장하는 경우)
        405: Method Not Allowed, 허용되지 않은 요청 메소드를 받았을 경우.
        408: Request Timeout, 요청 시간이 초과됨.
        409: Conflict, 서버가 요청을 처리하는 과정에서 충돌이 발생한 경우. (회원가입 중 중복된 아이디인 경우)
        410: Gone, 영구적으로 사용할 수 없는 페이지.
    */
    BAD_REQUEST(400, "BAD_REQUEST"),
    UNAUTHORIZED(401, "UNAUTHORIZED"),
    FORBIDDEN(403, "FORBIDDEN"),
    NOT_FOUND(404, "NOT_FOUND"),
    METHOD_NOT_ALLOWED(405, "METHOD_NOT_ALLOWED"),
    REQUEST_TIMEOUT(408, "REQUEST_TIMEOUT"),
    CONFLICT(409, "CONFLICT"),
    GONE(410, "GONE"),

    /** 500 서버 오류
        501: Not Implemented, 해당 요청을 처리하는 기능이 만들어지지 않음.
        502: Bad Gateway, 서버로 가능 요청이 중간에서 유실된 경우.
        503: Service Unavailable, 서버가 터졌거나 유지 보수 중(유지 보수 중일때는 유지 보수 중이라는 것을 알려주는 페이지로 전송해주는 것이 좋음)
        504: Gateway Timeout, 서버 게이트웨이에 문제가 생겨 시간 초과가 된 경우.
        505: HTTP Version Not Surpported, HTTP 버전이 달라 요청이 처리할 수 없음.
    */
    INTERNAL_SERVER_ERROR(500, "INTERNAL_SERVER_ERROR"),
    NOT_IMPLEMENTED(501, "NOT_IMPLEMENTED"),
    BAD_GATEWAY(502, "BAD_GATEWAY"),
    SERVICE_UNAVAILABLE(503, "SERVICE_UNAVAILABLE"),
    GATEWAY_TIMEOUT(504, "GATEWAY_TIMEOUT"),
    HTTP_VERSION_NOT_SUPPORTED(505, "HTTP_VERSION_NOT_SUPPORTED")
    ;

    int statusCode;
    String code;

    StatusEnum(int statusCode, String code) {
        this.statusCode = statusCode;
        this.code = code;
    }
}
