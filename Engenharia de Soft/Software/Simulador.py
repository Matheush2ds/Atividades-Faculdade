from tkinter import *
import sqlite3

class PostIt:
    def __init__(self, root):
        self.root = root
        self.root.title("Simulador de Post-it")

        self.title_entry = Entry(self.root, font=("Arial", 14))
        self.title_entry.pack(pady=5)

        self.desc_entry = Entry(self.root, font=("Arial", 14))
        self.desc_entry.pack(pady=5)

        self.date_entry = Entry(self.root, font=("Arial", 14))
        self.date_entry.pack(pady=5)

        self.add_button = Button(self.root, text="Adicionar", command=self.adicionar_postit)
        self.add_button.pack(pady=5)

        self.postit_frame = Frame(self.root)
        self.postit_frame.pack(pady=10)

        self.postits = []

        # Conexão com o banco de dados
        self.conn = sqlite3.connect('postits.db')
        self.c = self.conn.cursor()

        # Criação da tabela se não existir
        self.c.execute("CREATE TABLE IF NOT EXISTS postits (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT, Descrição TEXT, Prazo Final TEXT)")

        # Carregar post-its existentes do banco de dados
        self.carregar_postits()

    def adicionar_postit(self):
        title = self.title_entry.get()
        desc = self.desc_entry.get()
        date = self.date_entry.get()

        if title and desc and date:
            postit = Label(self.postit_frame, text=f"Titulo: {title}\nDescrição: {desc}\nPrazo Final: {date}",
                           bg="yellow", padx=10, pady=10)
            postit.pack(pady=5)
            self.postits.append(postit)

            # Inserir novo post-it no banco de dados
            self.c.execute("INSERT INTO postits (titulo, Descrição, Prazo Final) VALUES (?, ?, ?)", (title, desc, date))
            self.conn.commit()

            self.title_entry.delete(0, END)
            self.desc_entry.delete(0, END)
            self.date_entry.delete(0, END)

    def carregar_postits(self):
        # Carregar post-its do banco de dados
        self.c.execute("SELECT * FROM postits")
        rows = self.c.fetchall()

        for row in rows:
            postit_id = row[0]
            title = row[1]
            desc = row[2]
            date = row[3]
            postit = Label(self.postit_frame, text=f"ID: {postit_id}\ntitulo: {title}\nDescrição: {desc}\nPrazo Final: {date}",
                           bg="yellow", padx=10, pady=10)
            postit.pack(pady=5)

            remove_button = Button(self.postit_frame, text="Remover", command=lambda id=postit_id: self.remover_postit(id))
            remove_button.pack(pady=2)

            edit_button = Button(self.postit_frame, text="Editar", command=lambda id=postit_id: self.editar_postit(id))
            edit_button.pack(pady=2)

            self.postits.append((postit, remove_button, edit_button))

    def remover_postit(self, postit_id):
        # Remover post-it do banco de dados
        self.c.execute("DELETE FROM postits WHERE id=?", (postit_id,))
        self.conn.commit()

        # Remover post-it da interface
        for postit, remove_button, edit_button in self.postits:
            if postit_id == int(postit.cget("text").split("\n")[0].split(": ")[1]):
                postit.pack_forget()
                remove_button.pack_forget()
                edit_button.pack_forget()
                self.postits.remove((postit, remove_button, edit_button))
                break

    def editar_postit(self, postit_id):
        # Obter informações do post-it a ser editado
        for postit, remove_button, edit_button in self.postits:
            if postit_id == int(postit.cget("text").split("\n")[0].split(": ")[1]):
                info = postit.cget("text").split("\n")
                title = info[1].split(": ")[1]
                desc = info[2].split(": ")[1]
                date = info[3].split(": ")[1]

                # Preencher campos de edição com as informações do post-it
                self.title_entry.delete(0, END)
                self.title_entry.insert(0, title)
                self.desc_entry.delete(0, END)
                self.desc_entry.insert(0, desc)
                self.date_entry.delete(0, END)
                self.date_entry.insert(0, date)

                # Remover post-it da interface
                postit.pack_forget()
                remove_button.pack_forget()
                edit_button.pack_forget()
                self.postits.remove((postit, remove_button, edit_button))
                break

    def __del__(self):
        # Fechar a conexão com o banco de dados quando a aplicação for encerrada
        self.conn.close()

root = Tk()
postit_app = PostIt(root)
root.mainloop()
