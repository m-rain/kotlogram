package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.help.TLAbsAppUpdate;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestHelpGetAppUpdate extends TLMethod<TLAbsAppUpdate> {
    public static final int CONSTRUCTOR_ID = 0xc812ac7e;

    protected String deviceModel;

    protected String systemVersion;

    protected String appVersion;

    protected String langCode;

    private final String _constructor = "help.getAppUpdate#c812ac7e";

    public TLRequestHelpGetAppUpdate() {
    }

    public TLRequestHelpGetAppUpdate(String deviceModel, String systemVersion, String appVersion, String langCode) {
        this.deviceModel = deviceModel;
        this.systemVersion = systemVersion;
        this.appVersion = appVersion;
        this.langCode = langCode;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLAbsAppUpdate deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsAppUpdate)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLAbsAppUpdate) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(deviceModel, stream);
        writeString(systemVersion, stream);
        writeString(appVersion, stream);
        writeString(langCode, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        deviceModel = readTLString(stream);
        systemVersion = readTLString(stream);
        appVersion = readTLString(stream);
        langCode = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(deviceModel);
        size += computeTLStringSerializedSize(systemVersion);
        size += computeTLStringSerializedSize(appVersion);
        size += computeTLStringSerializedSize(langCode);
        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLRequestHelpGetAppUpdate)) return false;
        if (object == this) return true;

        TLRequestHelpGetAppUpdate o = (TLRequestHelpGetAppUpdate) object;

        return (deviceModel == o.deviceModel || (deviceModel != null && o.deviceModel != null && deviceModel.equals(o.deviceModel)))
                && (systemVersion == o.systemVersion || (systemVersion != null && o.systemVersion != null && systemVersion.equals(o.systemVersion)))
                && (appVersion == o.appVersion || (appVersion != null && o.appVersion != null && appVersion.equals(o.appVersion)))
                && (langCode == o.langCode || (langCode != null && o.langCode != null && langCode.equals(o.langCode)));
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }
}
