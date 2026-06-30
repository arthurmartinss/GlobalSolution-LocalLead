-- Gerado por Oracle SQL Developer Data Modeler 24.3.1.351.0831
--   em:        2026-06-05 16:51:27 BRT
--   site:      Oracle Database 11g
--   tipo:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE ALERTA 
    ( 
     id_alerta              NUMBER  NOT NULL , 
     nm_titulo              VARCHAR2 (100 CHAR)  NOT NULL , 
     ds_mensagem            VARCHAR2 (300 CHAR) , 
     tp_nivel_alerta        VARCHAR2 (30 CHAR) , 
     dt_envio               DATE , 
     tp_canal_envio         VARCHAR2 (50) , 
     PREV_OPER_id_prev_oper NUMBER  NOT NULL 
    ) 
;

ALTER TABLE ALERTA 
    ADD CONSTRAINT ALERTA_PK PRIMARY KEY ( id_alerta ) ;

CREATE TABLE CLIMA 
    ( 
     id_clima           NUMBER  NOT NULL , 
     nm_cidade          VARCHAR2 (100 CHAR)  NOT NULL , 
     nr_temperatura     NUMBER , 
     pc_umidade         NUMBER , 
     ds_condicao        VARCHAR2 (100 CHAR) , 
     dt_registro        DATE , 
     ds_fonte           VARCHAR2 (100 CHAR) , 
     SISTEMA_id_sistema NUMBER  NOT NULL 
    ) 
;

ALTER TABLE CLIMA 
    ADD CONSTRAINT CLIMA_PK PRIMARY KEY ( id_clima ) ;

CREATE TABLE ESTACAO 
    ( 
     id_estacao              NUMBER  NOT NULL , 
     nm_estacao              VARCHAR2 (100 CHAR)  NOT NULL , 
     nr_latitude             NUMBER , 
     nr_longitude            NUMBER , 
     nm_municipio            VARCHAR2 (100 CHAR) , 
     fl_acessibilidade       VARCHAR2 (1 CHAR) , 
     MAPA_TRANSPORTE_id_mapa NUMBER  NOT NULL 
    ) 
;

ALTER TABLE ESTACAO 
    ADD CONSTRAINT ESTACAO_PK PRIMARY KEY ( id_estacao ) ;

CREATE TABLE INFORMACAO_TRANSPORTE 
    ( 
     id_info_transporte  NUMBER  NOT NULL , 
     dt_atualizacao      DATE , 
     ds_fonte            VARCHAR2 (100 CHAR) , 
     tp_informacao       VARCHAR2 (30 CHAR)  NOT NULL , 
     LINHA_CPTM_id_linha NUMBER  NOT NULL 
    ) 
;

ALTER TABLE INFORMACAO_TRANSPORTE 
    ADD CONSTRAINT INFORMACAO_TRANSPORTE_PK PRIMARY KEY ( id_info_transporte ) ;

CREATE TABLE INTERVALO_TREM 
    ( 
     id_intervalo               NUMBER  NOT NULL , 
     dt_horario_inicio          DATE  NOT NULL , 
     dt_horario_fim             DATE , 
     qt_intervalo_min           NUMBER , 
     INFO_TRANSP_id_info_transp NUMBER  NOT NULL 
    ) 
;

ALTER TABLE INTERVALO_TREM 
    ADD CONSTRAINT INTERVALO_TREM_PK PRIMARY KEY ( id_intervalo ) ;

CREATE TABLE LINHA_CPTM 
    ( 
     id_linha                NUMBER  NOT NULL , 
     cd_linha                VARCHAR2 (10)  NOT NULL , 
     nm_linha                VARCHAR2 (100 CHAR)  NOT NULL , 
     ds_cor                  VARCHAR2 (50 CHAR) , 
     ds_sentido              VARCHAR2 (100 CHAR) , 
     nm_operadora            VARCHAR2 (80 CHAR) , 
     MAPA_TRANSPORTE_id_mapa NUMBER  NOT NULL 
    ) 
;

ALTER TABLE LINHA_CPTM 
    ADD CONSTRAINT LINHA_CPTM_PK PRIMARY KEY ( id_linha ) ;

CREATE TABLE LINHA_ESTACAO 
    ( 
     id_linha_estacao    NUMBER  NOT NULL , 
     nr_ordem_estacao    NUMBER  NOT NULL , 
     ds_plataforma       VARCHAR2 (40 CHAR) , 
     qt_tempo_medio_prox NUMBER , 
     LINHA_CPTM_id_linha NUMBER  NOT NULL , 
     ESTACAO_id_estacao  NUMBER  NOT NULL 
    ) 
;

ALTER TABLE LINHA_ESTACAO 
    ADD CONSTRAINT LINHA_ESTACAO_PK PRIMARY KEY ( id_linha_estacao ) ;

CREATE TABLE LOTACAO 
    ( 
     id_lotacao                 NUMBER  NOT NULL , 
     pc_lotacao                 NUMBER , 
     tp_nivel_lotacao           VARCHAR2 (200 CHAR) , 
     dt_registro                DATE , 
     INFO_TRANSP_id_info_transp NUMBER  NOT NULL , 
     ESTACAO_id_estacao         NUMBER  NOT NULL 
    ) 
;

ALTER TABLE LOTACAO 
    ADD CONSTRAINT LOTACAO_PK PRIMARY KEY ( id_lotacao ) ;

CREATE TABLE MAPA_TRANSPORTE 
    ( 
     id_mapa            NUMBER  NOT NULL , 
     nm_regiao          VARCHAR2 (100 CHAR)  NOT NULL , 
     qt_estacoes        NUMBER , 
     qt_linhas          NUMBER , 
     dt_atualizacao     DATE , 
     SISTEMA_id_sistema NUMBER  NOT NULL 
    ) 
;

ALTER TABLE MAPA_TRANSPORTE 
    ADD CONSTRAINT MAPA_TRANSPORTE_PK PRIMARY KEY ( id_mapa ) ;

CREATE TABLE PREVISAO_CLIMATICA 
    ( 
     id_previsao_clima NUMBER  NOT NULL , 
     dt_previsao       DATE  NOT NULL , 
     nr_temp_minima    NUMBER , 
     nr_temp_maxima    NUMBER , 
     pc_chance_chuva   NUMBER , 
     CLIMA_id_clima    NUMBER  NOT NULL 
    ) 
;

ALTER TABLE PREVISAO_CLIMATICA 
    ADD CONSTRAINT PREVISAO_CLIMATICA_PK PRIMARY KEY ( id_previsao_clima ) ;

CREATE TABLE PREVISAO_OPERACIONAL 
    ( 
     id_previsao_oper    NUMBER  NOT NULL , 
     tp_previsao         VARCHAR2 (50 CHAR)  NOT NULL , 
     tp_nivel_risco      VARCHAR2 (30 CHAR) , 
     ds_previsao         VARCHAR2 (300 CHAR)  NOT NULL , 
     pc_probabilidade    NUMBER , 
     dt_previsao_oper    DATE , 
     LINHA_CPTM_id_linha NUMBER  NOT NULL , 
     ESTACAO_id_estacao  NUMBER  NOT NULL , 
     CLIMA_id_clima      NUMBER  NOT NULL 
    ) 
;

ALTER TABLE PREVISAO_OPERACIONAL 
    ADD CONSTRAINT PREVISAO_OPERACIONAL_PK PRIMARY KEY ( id_previsao_oper ) ;

CREATE TABLE SISTEMA 
    ( 
     id_sistema     NUMBER  NOT NULL , 
     nm_sistema     VARCHAR2 (100 CHAR)  NOT NULL , 
     ds_versao      VARCHAR2 (20 CHAR) , 
     nm_cidade_base VARCHAR2 (100 CHAR) , 
     dt_criacao     DATE 
    ) 
;

ALTER TABLE SISTEMA 
    ADD CONSTRAINT SISTEMA_PK PRIMARY KEY ( id_sistema ) ;

CREATE TABLE STATUS_LINHA 
    ( 
     id_status_linha            NUMBER  NOT NULL , 
     st_linha                   VARCHAR2 (40 CHAR)  NOT NULL , 
     ds_mensagem                VARCHAR2 (250 CHAR) , 
     dt_status                  DATE , 
     INFO_TRANSP_id_info_transp NUMBER  NOT NULL 
    ) 
;

ALTER TABLE STATUS_LINHA 
    ADD CONSTRAINT STATUS_LINHA_PK PRIMARY KEY ( id_status_linha ) ;

CREATE TABLE USUARIO_ALERTA 
    ( 
     id_usuario_alerta      NUMBER  NOT NULL , 
     dt_recebimento         DATE , 
     fl_visualizado         VARCHAR2 (1 CHAR) , 
     USUARIO_APP_id_usuario NUMBER  NOT NULL 
    ) 
;

ALTER TABLE USUARIO_ALERTA 
    ADD CONSTRAINT USUARIO_ALERTA_PK PRIMARY KEY ( id_usuario_alerta ) ;

CREATE TABLE USUARIO_APP 
    ( 
     id_usuario  NUMBER  NOT NULL , 
     nm_usuario  VARCHAR2 (100 CHAR)  NOT NULL , 
     ds_email    VARCHAR2 (120 BYTE)  NOT NULL , 
     nr_telefone VARCHAR2 (20 CHAR) , 
     dt_cadastro DATE , 
     st_conta    VARCHAR2 (20 CHAR) 
    ) 
;

ALTER TABLE USUARIO_APP 
    ADD CONSTRAINT USUARIO_APP_PK PRIMARY KEY ( id_usuario ) ;

CREATE TABLE USUARIO_LINHA 
    ( 
     id_usuario_linha       NUMBER  NOT NULL , 
     ds_apelido_rota        VARCHAR2 (100 CHAR) , 
     dt_vinculo             DATE , 
     USUARIO_APP_id_usuario NUMBER  NOT NULL , 
     LINHA_CPTM_id_linha    NUMBER  NOT NULL 
    ) 
;

ALTER TABLE USUARIO_LINHA 
    ADD CONSTRAINT USUARIO_LINHA_PK PRIMARY KEY ( id_usuario_linha ) ;

ALTER TABLE ALERTA 
    ADD CONSTRAINT ALERTA_PREV_OPER_FK FOREIGN KEY 
    ( 
     PREV_OPER_id_prev_oper
    ) 
    REFERENCES PREVISAO_OPERACIONAL 
    ( 
     id_previsao_oper
    ) 
;

ALTER TABLE CLIMA 
    ADD CONSTRAINT CLIMA_SISTEMA_FK FOREIGN KEY 
    ( 
     SISTEMA_id_sistema
    ) 
    REFERENCES SISTEMA 
    ( 
     id_sistema
    ) 
;

ALTER TABLE ESTACAO 
    ADD CONSTRAINT ESTACAO_MAPA_TRANSPORTE_FK FOREIGN KEY 
    ( 
     MAPA_TRANSPORTE_id_mapa
    ) 
    REFERENCES MAPA_TRANSPORTE 
    ( 
     id_mapa
    ) 
;

ALTER TABLE INFORMACAO_TRANSPORTE 
    ADD CONSTRAINT INFO_TRANSP_LINHA_CPTM_FK FOREIGN KEY 
    ( 
     LINHA_CPTM_id_linha
    ) 
    REFERENCES LINHA_CPTM 
    ( 
     id_linha
    ) 
;

ALTER TABLE INTERVALO_TREM 
    ADD CONSTRAINT INFO_TRANSP_LINHA_CPTM_FKv2 FOREIGN KEY 
    ( 
     INFO_TRANSP_id_info_transp
    ) 
    REFERENCES INFORMACAO_TRANSPORTE 
    ( 
     id_info_transporte
    ) 
;

ALTER TABLE LINHA_CPTM 
    ADD CONSTRAINT LINHA_CPTM_MAPA_TRANSPORTE_FK FOREIGN KEY 
    ( 
     MAPA_TRANSPORTE_id_mapa
    ) 
    REFERENCES MAPA_TRANSPORTE 
    ( 
     id_mapa
    ) 
;

ALTER TABLE LINHA_ESTACAO 
    ADD CONSTRAINT LINHA_ESTACAO_ESTACAO_FK FOREIGN KEY 
    ( 
     ESTACAO_id_estacao
    ) 
    REFERENCES ESTACAO 
    ( 
     id_estacao
    ) 
;

ALTER TABLE LINHA_ESTACAO 
    ADD CONSTRAINT LINHA_ESTACAO_LINHA_CPTM_FK FOREIGN KEY 
    ( 
     LINHA_CPTM_id_linha
    ) 
    REFERENCES LINHA_CPTM 
    ( 
     id_linha
    ) 
;

ALTER TABLE LOTACAO 
    ADD CONSTRAINT LOTACAO_ESTACAO_FK FOREIGN KEY 
    ( 
     ESTACAO_id_estacao
    ) 
    REFERENCES ESTACAO 
    ( 
     id_estacao
    ) 
;

ALTER TABLE LOTACAO 
    ADD CONSTRAINT LOTACAO_INFO_TRANSP_FK FOREIGN KEY 
    ( 
     INFO_TRANSP_id_info_transp
    ) 
    REFERENCES INFORMACAO_TRANSPORTE 
    ( 
     id_info_transporte
    ) 
;

ALTER TABLE MAPA_TRANSPORTE 
    ADD CONSTRAINT MAPA_TRANSPORTE_SISTEMA_FK FOREIGN KEY 
    ( 
     SISTEMA_id_sistema
    ) 
    REFERENCES SISTEMA 
    ( 
     id_sistema
    ) 
;

ALTER TABLE PREVISAO_OPERACIONAL 
    ADD CONSTRAINT PREV_OPER_ESTACAO_FK FOREIGN KEY 
    ( 
     ESTACAO_id_estacao
    ) 
    REFERENCES ESTACAO 
    ( 
     id_estacao
    ) 
;

ALTER TABLE PREVISAO_OPERACIONAL 
    ADD CONSTRAINT PREV_OPER_LINHA_CPTM_FK FOREIGN KEY 
    ( 
     LINHA_CPTM_id_linha
    ) 
    REFERENCES LINHA_CPTM 
    ( 
     id_linha
    ) 
;

ALTER TABLE PREVISAO_CLIMATICA 
    ADD CONSTRAINT PREVISAO_CLIMATICA_CLIMA_FK FOREIGN KEY 
    ( 
     CLIMA_id_clima
    ) 
    REFERENCES CLIMA 
    ( 
     id_clima
    ) 
;

ALTER TABLE PREVISAO_OPERACIONAL 
    ADD CONSTRAINT PREVISAO_OPERACIONAL_CLIMA_FK FOREIGN KEY 
    ( 
     CLIMA_id_clima
    ) 
    REFERENCES CLIMA 
    ( 
     id_clima
    ) 
;

ALTER TABLE STATUS_LINHA 
    ADD CONSTRAINT STATUS_LINHA_INFO_TRANSP_FK FOREIGN KEY 
    ( 
     INFO_TRANSP_id_info_transp
    ) 
    REFERENCES INFORMACAO_TRANSPORTE 
    ( 
     id_info_transporte
    ) 
;

ALTER TABLE USUARIO_ALERTA 
    ADD CONSTRAINT USUARIO_ALERTA_USUARIO_APP_FK FOREIGN KEY 
    ( 
     USUARIO_APP_id_usuario
    ) 
    REFERENCES USUARIO_APP 
    ( 
     id_usuario
    ) 
;

ALTER TABLE USUARIO_LINHA 
    ADD CONSTRAINT USUARIO_LINHA_LINHA_CPTM_FK FOREIGN KEY 
    ( 
     LINHA_CPTM_id_linha
    ) 
    REFERENCES LINHA_CPTM 
    ( 
     id_linha
    ) 
;

ALTER TABLE USUARIO_LINHA 
    ADD CONSTRAINT USUARIO_LINHA_USUARIO_APP_FK FOREIGN KEY 
    ( 
     USUARIO_APP_id_usuario
    ) 
    REFERENCES USUARIO_APP 
    ( 
     id_usuario
    ) 
;



-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            16
-- CREATE INDEX                             0
-- ALTER TABLE                             35
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
