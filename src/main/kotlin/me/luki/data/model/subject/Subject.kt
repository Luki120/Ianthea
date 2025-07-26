package me.luki.data.model.subject

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
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
	@Serializable(with = LocalDateSerializer::class)
	val finalExamDate: LocalDate = LocalDate.now()
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
