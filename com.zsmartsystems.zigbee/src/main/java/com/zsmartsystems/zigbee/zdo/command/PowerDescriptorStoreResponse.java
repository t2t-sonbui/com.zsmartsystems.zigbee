package com.zsmartsystems.zigbee.zdo.command;

import com.zsmartsystems.zigbee.zdo.ZdoResponse;

/**
 * Power Descriptor Store Response value object class.
 * <p>
 * The Power_Desc_store_rsp is provided to notify a Local Device of the request
 * status from a Primary Discovery Cache device. Included in the response is a status
 * code to notify the Local Device whether the request is successful (the Primary
 * Cache Device has space to store the discovery cache data for the Local Device),
 * whether the request is not supported (meaning the Remote Device is not a Primary
 * Discovery Cache device), or insufficient space exists.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
public class PowerDescriptorStoreResponse extends ZdoResponse {
    /**
     * Default constructor.
     */
    public PowerDescriptorStoreResponse() {
        clusterId = 0x8018;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("PowerDescriptorStoreResponse");
        builder.append(super.toString());
        return builder.toString();
    }

}
