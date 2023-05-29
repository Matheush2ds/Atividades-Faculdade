from tkinter import *


class Contato:
    def __init__(self, nome, telefone):
        self.nome = nome
        self.telefone = telefone


class GerenciadorContatos:
    def __init__(self):
        self.contatos = []

    def adicionar_contato(self, nome, telefone):
        contato = Contato(nome, telefone)
        self.contatos.append(contato)
        print("Contato adicionado com sucesso!")

    def exibir_contatos(self):
        if self.contatos:
            print("Lista de Contatos:")
            for contato in self.contatos:
                print(f"Nome: {contato.nome} | Telefone: {contato.telefone}")
        else:
            print("Nenhum contato cadastrado.")

    def editar_contato(self, nome, novo_telefone):
        for contato in self.contatos:
            if contato.nome == nome:
                contato.telefone = novo_telefone
                print("Contato atualizado com sucesso!")
                return
        print("Contato não encontrado.")

    def remover_contato(self, nome):
        for contato in self.contatos:
            if contato.nome == nome:
                self.contatos.remove(contato)
                print("Contato removido com sucesso!")
                return
        print("Contato não encontrado.")


def adicionar_contato():
    nome = nome_entry.get()
    telefone = telefone_entry.get()

    gerenciador.adicionar_contato(nome, telefone)
    exibir_contatos()


def exibir_contatos():
    output_text.delete("1.0", END)

    if gerenciador.contatos:
        output_text.insert(END, "Lista de Contatos:\n")
        for contato in gerenciador.contatos:
            output_text.insert(END, f"Nome: {contato.nome} | Telefone: {contato.telefone}\n")
    else:
        output_text.insert(END, "Nenhum contato cadastrado.")


def editar_contato():
    nome = nome_entry.get()
    novo_telefone = telefone_entry.get()

    gerenciador.editar_contato(nome, novo_telefone)
    exibir_contatos()


def remover_contato():
    nome = nome_entry.get()

    gerenciador.remover_contato(nome)
    exibir_contatos()


# Janela principal
root = Tk()
root.title("Gerenciador de Contatos")

# Gerenciador de contatos
gerenciador = GerenciadorContatos()

# Criação dos widgets
nome_label = Label(root, text="Nome:")
nome_entry = Entry(root)
telefone_label = Label(root, text="Telefone:")
telefone_entry = Entry(root)
adicionar_button = Button(root, text="Adicionar", command=adicionar_contato)
editar_button = Button(root, text="Editar", command=editar_contato)
remover_button = Button(root, text="Remover", command=remover_contato)
exibir_button = Button(root, text="Exibir", command=exibir_contatos)
output_text = Text(root, width=40, height=10)

# Posicionamento dos widgets na janela
nome_label.grid(row=0, column=0, sticky=W)
nome_entry.grid(row=0, column=1)
telefone_label.grid(row=1, column=0, sticky=W)
telefone_entry.grid(row=1, column=1)
adicionar_button.grid(row=2, column=0)
editar_button.grid(row=2, column=1)
remover_button.grid(row=2, column=2)
exibir_button.grid(row=3, column=0, sticky=W)
output_text.grid(row=4, columnspan=3)

# Loop principal da janela
root.mainloop()