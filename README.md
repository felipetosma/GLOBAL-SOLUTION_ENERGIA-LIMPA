Sistema de Monitoramento e Emissão de Alertas de Condições Adversas para Operadores de Usinas Nucleares

O projeto visa desenvolver um sistema integrado de monitoramento e emissão de alertas para operadores de usinas nucleares, com o objetivo de garantir a segurança operacional e pessoal. O sistema é composto por três principais componentes:

1. Aplicativo Mobile de Monitoramento
Este aplicativo oferece uma plataforma intuitiva para os operadores monitorarem em tempo real as principais variáveis do reator nuclear. Os principais recursos incluem:
Login e Cadastro do Operador: Controle de acesso seguro aos dados sensíveis.
	- Tela Principal com Botões de Navegação:
	- Tela de Temperatura do Núcleo: Exibe a temperatura atual do núcleo do reator.
	- Tela de Pressão do Reator: Monitora a pressão interna do reator.
	- Tela de Fluxo de Refrigeração: Informa sobre o fluxo de líquido refrigerante.
	- Tela de Níveis de Radiação: Mostra os níveis de radiação nas áreas monitoradas.

Status Geral: Indica a situação geral (Normal, Alerta, Crítico) com base nos dados coletados.
Integração com Java e Banco de Dados Oracle: Armazena e gerencia os dados operacionais.

2. Aplicativo .NET para Relatório Diário de Trabalho
Este componente permite aos operadores registrar e acompanhar suas atividades diárias, proporcionando uma documentação padronizada das operações.
	- Login e Cadastro do Operador: Acesso seguro ao sistema.
	- Tela Principal de Relatório: Interface para registro detalhado de atividades.
	- Integração com Banco de Dados Oracle: Armazenamento de dados de forma centralizada e segura.

3. Deep Learning & Visão Computacional para Verificação de EPIs
O uso de tecnologias de deep learning permite a verificação automática dos Equipamentos de Proteção Individual (EPIs) usados pelos operadores antes de entrarem na sala de operações. As principais funcionalidades incluem:
	- Treinamento de Modelo de Machine Learning: Detecção de EPIs como máscaras, óculos de proteção e macacões.
	- Reconhecimento e Alerta: Identifica se os operadores estão devidamente equipados, garantindo conformidade com as normas de 	  segurança.

Objetivos do Projeto:
-Monitorar condições críticas do reator nuclear em tempo real.
-Emitir alertas em situações de risco para intervenção rápida.
-Registrar as atividades diárias dos operadores de forma eficiente.
-Garantir a segurança pessoal dos operadores através da verificação automática do uso de EPIs.
-Este projeto é relevante para a segurança nuclear, pois contribui para a prevenção de acidentes e assegura que os operadores estejam sempre cientes das condições em que trabalham. A integração das aplicações com um banco de dados robusto permite um armazenamento seguro e um acesso eficiente aos dados coletados.
