package med.manfrin.api.dtos.medico;

import med.manfrin.api.domain.medico.Especialidade;
import med.manfrin.api.domain.medico.Medico;

public record DadosListagemMedico(
        String nome,
        String email,
        String crm,
        Especialidade especialidade
) {
    public DadosListagemMedico(Medico medico){
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
