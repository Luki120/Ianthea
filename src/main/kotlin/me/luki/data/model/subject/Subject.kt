package me.luki.data.model.subject

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.LocalDate

@Serializable
data class Subject(
	val name: String,
	val year: String,
	val shortName: String = "",
	val examGrades: List<Int> = emptyList(),
	val finalGrades: List<Int> = emptyList(),
	val isFinished: Boolean = false,
	val hasThreeExams: Boolean = false,
    @Serializable(with = LocalDateListSerializer::class)
	val finalExamDates: List<LocalDate> = emptyList()
)

private object LocalDateSerializer: KSerializer<LocalDate> {
    override val descriptor = PrimitiveSerialDescriptor("LocalDate", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): LocalDate {
        val dateString = decoder.decodeString()
        return LocalDate.parse(dateString)
    }

    override fun serialize(encoder: Encoder, value: LocalDate) {
        encoder.encodeString(value.toString())
    }
}

private object LocalDateListSerializer : KSerializer<List<LocalDate>> {
    private val listSerializer = ListSerializer(LocalDateSerializer)
    override val descriptor = listSerializer.descriptor

    override fun deserialize(decoder: Decoder): List<LocalDate> {
        return listSerializer.deserialize(decoder)
    }

    override fun serialize(encoder: Encoder, value: List<LocalDate>) {
        listSerializer.serialize(encoder, value)
    }
}
