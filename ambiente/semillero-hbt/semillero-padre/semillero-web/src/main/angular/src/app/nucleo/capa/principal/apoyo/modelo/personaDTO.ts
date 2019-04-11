export interface PersonaDTO {
    id: string;
    nombre: string;
    apellido: string;
    tipoIdentificacion: string;
    numeroIdentificacion: number | string;
    mayorEdad: boolean;
    fechaNacimiento: Date;
    sexo: string;
}
