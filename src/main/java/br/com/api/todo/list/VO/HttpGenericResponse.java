package br.com.api.todo.list.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HttpGenericResponse {

    private String status;

    private String message;

    private Object response;
}
