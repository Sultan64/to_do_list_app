package com.example.todolist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.TextView;

import com.example.todolist.Model.Task;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    interface OnTaskClickListener {
        void onTaskClick(Task task, int position);
    }

    private final OnTaskClickListener onClickListener;
    private final LayoutInflater inflater;
    private final List<Task> tasks;

    TaskAdapter(Context context, List<Task> tasks, OnTaskClickListener onClickListener) {
        this.onClickListener = onClickListener;
        this.tasks = tasks;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.task_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TaskAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Task task = tasks.get(position);
        holder.header.setText(task.getHeader());
        holder.description.setText(task.getDescription());
        holder.itemView.setOnClickListener(v -> onClickListener.onTaskClick(task, position));
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView header, description;
        //CheckBox checkbox;
        ViewHolder(View view) {
            super(view);
            header = view.findViewById(R.id.header);
            description = view.findViewById(R.id.description);
            //checkbox = view.findViewById(R.id.checkbox);
        }
    }
}
