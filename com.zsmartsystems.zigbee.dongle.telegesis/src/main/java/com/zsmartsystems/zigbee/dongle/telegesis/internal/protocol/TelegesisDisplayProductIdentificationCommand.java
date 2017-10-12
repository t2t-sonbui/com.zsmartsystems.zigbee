/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.telegesis.internal.protocol;

import com.zsmartsystems.zigbee.IeeeAddress;

/**
 * Class to implement the Telegesis command <b>Display Product Identification</b>.
 * <p>
 * This class provides methods for processing Telegesis AT API commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class TelegesisDisplayProductIdentificationCommand extends TelegesisFrame implements TelegesisCommand {
    /**
     * Telegesis * response field
     * The order code of the device
     */
    private String deviceName;

    /**
     * R* response field
     */
    private String firmwareRevision;

    /**
     * Response field
     */
    private IeeeAddress ieeeAddress;

    /**
     * The order code of the device
     *
     * @return the deviceName as {@link String}
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     *
     * @return the firmwareRevision as {@link String}
     */
    public String getFirmwareRevision() {
        return firmwareRevision;
    }

    /**
     *
     * @return the ieeeAddress as {@link IeeeAddress}
     */
    public IeeeAddress getIeeeAddress() {
        return ieeeAddress;
    }

    @Override
    public int[] serialize() {
        // Serialize the command fields
        serializeCommand("ATI");

        return getPayload();
    }

    @Override
    public boolean deserialize(int[] data) {
        // Handle standard status responses (ie. OK / ERROR)
        if (handleIncomingStatus(data)) {
            return true;
        }

        initialiseDeserializer(data);

        // Deserialize the fields for the "Telegesis *" response
        if (testPrompt(data, "Telegesis ")) {
            setDeserializer(10);

            // Deserialize field "Device Name"
            deviceName = deserializeString();
            return false;
        }
        // Deserialize the fields for the "R*" response
        if (testPrompt(data, "R")) {
            setDeserializer(1);

            // Deserialize field "Firmware Revision"
            firmwareRevision = deserializeString();
            return false;
        }
        // Deserialize the fields for the response

        // Deserialize field "ieee address"
        ieeeAddress = deserializeIeeeAddress();

        return false;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(404);
        builder.append("TelegesisDisplayProductIdentificationCommand [deviceName=");
        builder.append(deviceName);
        builder.append(", firmwareRevision=");
        builder.append(firmwareRevision);
        builder.append(", ieeeAddress=");
        builder.append(ieeeAddress);
        if (status != null) {
            builder.append(", status=");
            builder.append(status);
        }
        builder.append(']');
        return builder.toString();
    }
}
