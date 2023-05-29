import matplotlib.pyplot as plt

def generate_burndown_chart(backlog, progress):
    total_work = sum(backlog)
    remaining_work = total_work
    ideal_burndown = [total_work]

    for p in progress:
        remaining_work -= p
        ideal_burndown.append(remaining_work)

    ideal_burndown.append(0)  # Adiciona o trabalho restante zero ao final

    # Plotando o gráfico burndown
    days = range(len(progress) + 1)  # Ajuste para ter o mesmo tamanho que progress
    plt.plot(days, ideal_burndown[:len(progress)+1], label='Ideal', linestyle='--', linewidth=2, color='blue')
    plt.plot(days[:-1], backlog[:len(progress)], label='Backlog', linestyle='-', linewidth=2, color='orange')
    plt.plot(days[:-1], progress, label='Progresso', linestyle='-', linewidth=2, color='green')

    # Adicionando marcações para cada ponto de progresso
    plt.scatter(days[:-1], progress, color='green', marker='o', s=80)

    plt.xlabel('Dias')
    plt.ylabel('Trabalho Restante')
    plt.title('Gráfico Burndown')
    plt.legend()
    plt.grid(True)

    # Adicionando anotações com os valores de trabalho restante
    for i, j in enumerate(progress):
        plt.annotate(str(j), xy=(i+0.5, j+0.5), xytext=(i+0.7, j+1), color='black', fontsize=10)

    plt.show()

# Dados do backlog e progresso
backlog = [4, 3, 6, 4, 6, 3, 4, 4, 6, 6, 5]
progress = [4, 3, 6, 2, 3, 2, 2, 4, 5, 3]

# Gerar o gráfico burndown
generate_burndown_chart(backlog, progress)
