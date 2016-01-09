package com.xiaoxin.adapter;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

/**
 * @author jack 使用说明
 * 
 *         public class DemoRVAdapter extends AutoRVAdapter {
 * 
 *         public DemoRVAdapter(Context context, List<?> list) { super(context,
 *         list); }
 * 
 * @Override public int onCreateViewLayoutID(int viewType) { return 0; } 返回item 的布局.
 * 
 * @Override public void onBindViewHolder(ViewHolder holder, int position) {
 * 									绑定数据源.
 *           // Entity item = (Entity) list.get(position); //
 *           vh.getTextView(R.id.name).setText(item.getName()); //
 *           vh.getTextView(R.id.age).setText(item.getAge()); //
 *           vh.setText(R.id.height, item.getHeight()); }
 * 
 *           }
 *
 */
public abstract class AutoRVAdapter extends RecyclerView.Adapter<RVHolder> {

	public List<?> list;

	private Context context;

	public AutoRVAdapter(Context context, List<?> list) {
		this.list = list;
		this.context = context;
	}

	@Override
	public RVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(context).inflate(onCreateViewLayoutID(viewType), null);

		return new RVHolder(view);
	}

	public abstract int onCreateViewLayoutID(int viewType);

	@Override
	public void onViewRecycled(final RVHolder holder) {
		super.onViewRecycled(holder);
	}

	@Override
	public void onBindViewHolder(final RVHolder holder, final int position) {

		onBindViewHolder(holder.getViewHolder(), position);
		if (onItemClickListener != null) {
			holder.itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					onItemClickListener.onItemClick(null, v, holder.getPosition(), holder.getItemId());
				}
			});
		}

	}

	public abstract void onBindViewHolder(ViewHolder holder, int position);

	@Override
	public int getItemCount() {
		return list.size();
	}

	private AdapterView.OnItemClickListener onItemClickListener;

	public AdapterView.OnItemClickListener getOnItemClickListener() {
		return onItemClickListener;
	}

	public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
		this.onItemClickListener = onItemClickListener;
	}
}
