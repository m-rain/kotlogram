package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPrivacyRule;
import com.github.badoualy.telegram.tl.api.TLInputPrivacyKeyStatusTimestamp;
import com.github.badoualy.telegram.tl.api.account.TLPrivacyRules;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestAccountSetPrivacy extends TLMethod<TLPrivacyRules> {
    public static final int CONSTRUCTOR_ID = 0xc9f81ce8;

    protected TLInputPrivacyKeyStatusTimestamp key;

    protected TLVector<? extends TLAbsInputPrivacyRule> rules;

    public TLRequestAccountSetPrivacy() {
    }

    public TLRequestAccountSetPrivacy(TLInputPrivacyKeyStatusTimestamp key, TLVector<? extends TLAbsInputPrivacyRule> rules) {
        this.key = key;
        this.rules = rules;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLPrivacyRules deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLPrivacyRules)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLPrivacyRules) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(key, stream);
        writeTLVector(rules, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        key = (com.github.badoualy.telegram.tl.api.TLInputPrivacyKeyStatusTimestamp) readTLObject(stream, context);
        rules = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "account.setPrivacy#c9f81ce8";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public TLInputPrivacyKeyStatusTimestamp getKey() {
        return key;
    }

    public void setKey(TLInputPrivacyKeyStatusTimestamp key) {
        this.key = key;
    }

    public TLVector<? extends TLAbsInputPrivacyRule> getRules() {
        return rules;
    }

    public void setRules(TLVector<? extends TLAbsInputPrivacyRule> rules) {
        this.rules = rules;
    }
}
