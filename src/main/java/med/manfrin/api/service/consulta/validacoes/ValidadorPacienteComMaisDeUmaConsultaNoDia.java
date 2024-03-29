package med.manfrin.api.service.consulta.validacoes;

import med.manfrin.api.dtos.consulta.DadosAgendamentoConsulta;
import med.manfrin.api.infra.exception.ValidacaoAgendamentoException;
import med.manfrin.api.repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteComMaisDeUmaConsultaNoDia implements ValidadorAgendamentoConsulta{

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiOutraConsultaNoDia = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(),primeiroHorario,ultimoHorario);

        if (pacientePossuiOutraConsultaNoDia){
            throw new ValidacaoAgendamentoException("Paciente já possui uma consulta agendada nesse dia");
        }
    }
}
