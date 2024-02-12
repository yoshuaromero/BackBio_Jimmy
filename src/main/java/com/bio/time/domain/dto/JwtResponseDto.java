package com.bio.time.domain.dto;


import com.bio.time.domain.dto.user.MenuProfileStageDto;

import java.util.List;

public class JwtResponseDto extends AuthTokensDto {

        private String token;
        private Integer userId;
        private String username;
        private String email;
        private String cellphone;
        private String name;
        private String lastname;
        private Integer idProfile;
        private Integer visualDisability;
        private Integer idStatus;
        private Integer idPaymentMethod;
        private  List<MenuProfileStageDto> listMenu;

        public JwtResponseDto(String token, Integer userId, String username, String email, String cellphone, String name,
                              String lastname, Integer idProfile, Integer idStatus, List<MenuProfileStageDto> listMenu) {
                this.token = token;
                this.userId = userId;
                this.username = username;
                this.email = email;
                this.cellphone = cellphone;
                this.name = name;
                this.lastname = lastname;
                this.idProfile = idProfile;
                this.idStatus = idStatus;
                this.listMenu = listMenu;
        }

        public String getToken() {
                return token;
        }

        public void setToken(String token) {
                this.token = token;
        }

        public Integer getUserId() {
                return userId;
        }

        public void setUserId(Integer userId) {
                this.userId = userId;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getCellphone() {
                return cellphone;
        }

        public void setCellphone(String cellphone) {
                this.cellphone = cellphone;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getLastname() {
                return lastname;
        }

        public void setLastname(String lastname) {
                this.lastname = lastname;
        }

        public Integer getIdProfile() {
                return idProfile;
        }

        public void setIdProfile(Integer idProfile) {
                this.idProfile = idProfile;
        }

        public Integer getVisualDisability() {
                return visualDisability;
        }

        public void setVisualDisability(Integer visualDisability) {
                this.visualDisability = visualDisability;
        }

        public Integer getIdStatus() {
                return idStatus;
        }

        public void setIdStatus(Integer idStatus) {
                this.idStatus = idStatus;
        }

        public Integer getIdPaymentMethod() {
                return idPaymentMethod;
        }

        public void setIdPaymentMethod(Integer idPaymentMethod) {
                this.idPaymentMethod = idPaymentMethod;
        }

        public List<MenuProfileStageDto> getListMenu() {
                return listMenu;
        }

        public void setListMenu(List<MenuProfileStageDto> listMenu) {
                this.listMenu = listMenu;
        }
}