package com.rsp.myserver.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

@ConfigurationProperties("security")
public class SecurityProperties {

    private JwtProperties jwt;

    private MacProperties mac;

    public JwtProperties getJwt() {
        return jwt;
    }

    public void setJwt(JwtProperties jwt) {
        this.jwt = jwt;
    }

    public MacProperties getMac() {
        return mac;
    }

    public void setMac(MacProperties mac) {
        this.mac = mac;
    }

    public static class JwtProperties {

        private Resource keyStore;
        private String keyStorePassword;
        private String keyPairAlias;
        private String keyPairPassword;

        public Resource getKeyStore() {
            return keyStore;
        }

        public void setKeyStore(Resource keyStore) {
            this.keyStore = keyStore;
        }

        public String getKeyStorePassword() {
            return keyStorePassword;
        }

        public void setKeyStorePassword(String keyStorePassword) {
            this.keyStorePassword = keyStorePassword;
        }

        public String getKeyPairAlias() {
            return keyPairAlias;
        }

        public void setKeyPairAlias(String keyPairAlias) {
            this.keyPairAlias = keyPairAlias;
        }

        public String getKeyPairPassword() {
            return keyPairPassword;
        }

        public void setKeyPairPassword(String keyPairPassword) {
            this.keyPairPassword = keyPairPassword;
        }
    }

    public static class MacProperties {
        private String key;
        private String delimiter;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getDelimiter() {
            return delimiter;
        }

        public void setDelimiter(String delimiter) {
            this.delimiter = delimiter;
        }
    }
}
