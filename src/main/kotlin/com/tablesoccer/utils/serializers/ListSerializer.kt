package com.tablesoccer.utils.serializers

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.jsonArray

class ListSerializer<E>(private val elementSerializer: KSerializer<E>) : KSerializer<List<E>> {
    private val listSerializer = ListSerializer(elementSerializer)
    override val descriptor: SerialDescriptor = listSerializer.descriptor

    override fun serialize(encoder: Encoder, value: List<E>) {
        listSerializer.serialize(encoder, value)
    }

    override fun deserialize(decoder: Decoder): List<E> = with(decoder as JsonDecoder) {
        decodeJsonElement().jsonArray.mapNotNull {
            try {
                json.decodeFromJsonElement(elementSerializer, it)
            } catch (e: SerializationException) {
                e.printStackTrace()
                null
            }
        }
    }
}